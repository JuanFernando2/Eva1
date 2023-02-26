package dao;

public class CineDAO {
	static db.Db db=new db.Db("CineStar");
	
	public static String[][] getVerCines(){
		db.Sentencia("call sp_getCines()");
		return db.getRegistros();
	}

}
