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


    //поля для заполнения: Имя, Фамилия, Адрес, Телефон, Дата(дд/мм/гггг), Комментарий
    public static final Object[] ORDER_OBJ_1 =
            {"Василий",
                    "Сизов",
                    "ул.Пушкина, д.15",
                    "+71234567887",
                    "25.08.2023",
                    "без комментариев",
                    "Заказ оформлен",};
    public static final Object[] ORDER_OBJ_2 =
            {"Иван",
                    "Петров",
                    "ул.Вагнера, д.4, корп.5",
                    "+712345678864",
                    "25.08.2023",
                    "хочу самокат",
                    "Заказ оформлен",};
    public static final Object[][] ACCORDION_OBJ_ARR = {
            {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
            {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
            {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
            {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
            {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
            {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
            {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
            {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
    };

    public static final int IMPL_WAIT = 50;
    public static final int PG_LOAD_TMT = 50;
    public static final int SCR_TMT = 50;
};