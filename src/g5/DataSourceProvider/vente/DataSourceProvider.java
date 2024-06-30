/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g5.DataSourceProvider.vente;
import org.sqlite.JDBC;
import org.sqlite.SQLiteDataSource;
import javax.sql.DataSource;
/**
 *
 * @author kallo
 */
public class DataSourceProvider {
    
    private static SQLiteDataSource singleDataSource;

    public static DataSource getSingleDataSourceInstance() {
    if (singleDataSource == null) {
        singleDataSource = new SQLiteDataSource();
        singleDataSource.setUrl("jdbc:sqlite:/D:\\JAVA FX\\projetJavaGv\\database\\g5Vente.db");
    }
    return singleDataSource;
 }
}
