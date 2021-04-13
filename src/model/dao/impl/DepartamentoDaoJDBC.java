package model.dao.impl;

import java.util.List;

import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDao {
	


    private Connection conn;

    public ProdutoDaoJDBC(Connection conn) {
                this.conn=conn;
    }

	@Override
	public void insert(Departamento obj) {
		PreparedStatement st = null;
		try {
				st = conn.prepareStatement("insert into departamento "
								+ "(no_departamento) "
								+ "values (?) ",
								Statement.RETURN_GENERATED_KEYS
								);

				st.setString(1, obj.getNo_departamento());

				int rowsAffected = st.executeUpdate();

				if (rowsAffected > 0) {
							ResultSet rs = st.getGeneratedKeys();
							if  (rs.next()) {
									int id = rs.getInt(1);
									obj.setId(id);
							}
							DB.closeResultSet(rs);
				}
				else {
						throw new DbException ("Erro Inexperado: N├úo  houve Inclus├úo!");
				}

		}
		catch (SQLException e) {
				throw new DbException (e.getMessage());
		}
		finally {
				DB.closeStatement(st);
		}

		
	}

	@Override
	public void udpdate(Departamento obj) {
				PreparedStatement st = null;
		try {
				st = conn.prepareStatement("update  departamento set "
								+ "no_departamento = ? "
								+ "where id = ? "
								);

				st.setString(1, obj.getNo_departamento());
				 st.setInt(2,obj.getId());


				int rowsAffected = st.executeUpdate();

				if (rowsAffected > 0) {
					// nada por enquanto
				}
				else {
						throw new DbException ("Departamento não Existe para Alteração!");
				}

		}
		catch (SQLException e) {
				throw new DbException (e.getMessage());
		}
		finally {
				DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
				st = conn.prepareStatement("delete from departamento  "
								+ "where id = ?"
								);

				st.setInt(1,id);

				int rowsAffected = st.executeUpdate();

				if (rowsAffected == 0 ) {
						throw  new DbException("ID N├âO EXITE PARA EXCLUIR!");
				}

		}
		catch (SQLException e) {
				throw new DbException (e.getMessage());
		}
		finally {
				DB.closeStatement(st);
		}

		
	}

	@Override
	public Departamento findByid(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
				st = conn.prepareStatement(
								"select * from departamento  "
								+ "where produto.id = ?"
								);
				st.setInt(1, id);
				rs = st.executeQuery();
				if (rs.next()) {
					Departamento obj = instantiateDepartamento(rs);

					return obj;
				}
				return null;
		}
		catch (SQLException e){
				throw new  DbException(e.getMessage());
		}
		finally {
				DB.closeStatement(st);
				DB.closeResultSet(rs);
		}


	}

	@Override
	public List<Departamento> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
				st = conn.prepareStatement(
								"select * from departamento  "
								);
				st.setInt(1, id);
				rs = st.executeQuery();
				if (rs.next()) {
					Departamento obj = instantiateDepartamento(rs);

					return obj;
				}
				return null;
		}
		catch (SQLException e){
				throw new  DbException(e.getMessage());
		}
		finally {
				DB.closeStatement(st);
				DB.closeResultSet(rs);
		}

	}

	private Departamento instantiateDepartamento(ResultSet rs) throws SQLException {
		Departamento forn = new Departamento();
		forn.setId(rs.getInt("id_Departamento"));
		forn.setNo_Departamento(rs.getString("no_Departamento"));
		return forn;
	}


}
