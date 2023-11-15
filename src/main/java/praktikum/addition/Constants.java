package praktikum.addition;

public class Constants {
    //Pages
    public static final String HOME = "https://stellarburgers.nomoreparties.site/";
    public static final String FEED = "https://stellarburgers.nomoreparties.site/feed";
    public static final String LOGIN = "https://stellarburgers.nomoreparties.site/login";
    public static final String FORGOT_PASSWORD = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String REGISTER = "https://stellarburgers.nomoreparties.site/register";
    public static final String ACCOUNT = "https://stellarburgers.nomoreparties.site/account";
    public static final String PROFILE = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String ORDER_HISTORY = "https://stellarburgers.nomoreparties.site/account/order-history";
    //Handles
    public static final String USER_REGISTER_HANDLE = "/api/auth/register";
    public static final String USER_CHANGE_DELETE_HANDLE = "/api/auth/user";
    public static final String USER_LOGIN_HANDLE = "/api/auth/login";
    //Messages
    public static final String AUTHORIZATION_NOT_POSSIBLE = "Пользователь не был создан. Авторизация невозможна.";
    public static final String INCORRECT_PASSWORD = "Некорректный пароль";
    //Files
    public static final String SUCCESS_LOGIN = "src/test/resources/users/ivan_sidorov.json";
    public static final String LOGIN_WITH_WRONG_PASSWORD = "src/test/resources/users/wrong_password.json";

    public static final int IMPL_WAIT = 10;
    public static final int PG_LOAD_TMT = 10;
    public static final int SCR_TMT = 10;
};