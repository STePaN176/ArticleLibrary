package conf;

public class AppConfig {

    static String adressDb = "jdbc:sqlite:C:/Users/176kr/IdeaProjects/MyProject/ArticleLibrary/DB/ArticleLibraryDb.db";

    public static String getAdressDb() {
        return adressDb;
    }

    public static void setAdressDb(String adressDb) {
        AppConfig.adressDb = adressDb;
    }

}
