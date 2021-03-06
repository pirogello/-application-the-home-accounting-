package individualFinance.settings;

import java.util.HashMap;

public class Text {
	private final static HashMap<String,String> data = new HashMap<>();

	public static String get(String key){
		if (data.containsKey(key)) return data.get(key);
		System.out.println("Такого ключа не существует");//для отладнки
		return "";
	}

	public static String[] getMonths(){
		String[] retM = new String[12];
		retM[0] = data.get("JANUARY");
		retM[1] =data.get("FEBRUARY");
		retM[2] =data.get("MARCH");
		retM[3] =data.get("APRIL");
		retM[4] =data.get("MAY");
		retM[5] =data.get("JUN");
		retM[6] =data.get("JULY");
		retM[7] =data.get("AUGUST");
		retM[8] =data.get("SEPTEMBER");
		retM[9] =data.get("OCTOBER");
		retM[10] =data.get("NOVEMBER");
		retM[11] =data.get("NOVEMBER");
		return retM;
	}

	public static void init() {
		data.put("PROGRAM_NAME", "Домашняя бухгалтерия");
		data.put("MENU_FILE", "Файл");
		data.put("MENU_EDIT", "Правка");
		data.put("MENU_VIEW", "Вид");
		data.put("MENU_HELP", "Помощь");

		data.put("MENU_FILE_NEW", "Новый");
		data.put("MENU_FILE_OPEN", "Открыть");
		data.put("MENU_FILE_SAVE", "Сохранить");
		data.put("MENU_FILE_UPDATE_CURRENCIES", "Обновить курс валют");
		data.put("MENU_FILE_EXIT", "Выход из аккаунта");

		data.put("MENU_EDIT_ADD", "Добавить");
		data.put("MENU_EDIT_EDIT", "Nзменить");
		data.put("MENU_EDIT_DELETE", "Удалить");

		data.put("MENU_VIEW_OVERVIEW", "Обзор");
		data.put("MENU_VIEW_ACCOUNTS", "Счета");
		data.put("MENU_VIEW_ARTICLES", "Статьи");
		data.put("MENU_VIEW_CURRENCIES", "Валюты");
		data.put("MENU_VIEW_STATISTICS", "Статистика");
		data.put("MENU_VIEW_TRANSACTIONS", "Транзакции");
		data.put("MENU_VIEW_TRANSFERS", "Переводы");

		data.put("MENU_HELP_ABOUT", "О программе");

		data.put("TOOLBAR_OVERVIEW", "Обзор");
		data.put("TOOLBAR_ACCOUNTS", "Счета");
		data.put("TOOLBAR_ARTICLES", "Статьи");
		data.put("TOOLBAR_CURRENCIES", "Валюты");
		data.put("TOOLBAR_TRANSFERS", "Переводы");
		data.put("TOOLBAR_STATISTICS", "Статистика");
		data.put("TOOLBAR_TRANSACTIONS", "Транзакции");

		data.put("ADD", "Добавить");
		data.put("EDIT", "Nзменить");
		data.put("DELETE", "Удалить");
		data.put("CANCEL", "Отменить");


		data.put("JANUARY", "Январь");
		data.put("FEBRUARY", "Февраль");
		data.put("MARCH", "Март");
		data.put("APRIL", "Апрель");
		data.put("MAY", "Май");
		data.put("JUN", "Nюнь");
		data.put("JULY", "Nюль");
		data.put("AUGUST", "Август");
		data.put("SEPTEMBER", "Сентябрь");
		data.put("OCTOBER", "Октябрь");
		data.put("NOVEMBER", "Ноябрь");
		data.put("DECEMBER", "Декабрь");

		data.put("ERROR", "Ошибка");
		data.put("ERROR_TITLE_EMPTY", "Вы не ввели название");
		data.put("ERROR_IS_EXIST", "Такая запись уже существует");
		data.put("ERROR_DATA_FORMAT", "Некорректный формат даты");
		data.put("ERROR_CODE_EMPTY", "Вы не указали код");
		data.put("ERROR_CURRENCY_EMPTY", "Вы не выбрали валюту");
		data.put("ERROR_ARTICLE_EMPTY", "Вы не выбрали статью");
		data.put("ERROR_ACCOUNT_EMPTY", "Вы не выбрали счет");
		data.put("ERROR_RATE_INCORRECT", "Некорректное значение курса");
		data.put("ERROR_AMOUNT_FORMAT", "Некорректный формат суммы");
		data.put("ERROR_NO_BASE_CURRENCY", "Необходима базовая валюта");
		data.put("ERROR_UPDATE_CURRENCY", "Ошибка обновления курса валют");

		data.put("CONFIRM_EXIT_TEXT", "Вы действительно хотите выйти? Все не сохраненные данные будут утеряны");
		data.put("CONFIRM_EXIT_TITLE", "Подтверждение выхода");
		data.put("CONFIRM_DELETE_TEXT", "Вы уверены, что хотите удалить данные?");
		data.put("CONFIRM_TITLE", "Подтверждение удаления");

		data.put("YES", "Да");
		data.put("NO", "Нет");

		data.put("TODAY", "Сегодня");

		data.put("FC_HOME", "Домашняя дирректория");
		data.put("FC_OPEN", "Открыть");
		data.put("FC_SAVE", "Сохранить");
		data.put("FC_CANCEL", "Отменить");
		data.put("FC_LOOK", "Папка:");
		data.put("FC_NAME_FILE", "Nмя файла:");
		data.put("FC_TYPE_FILE", "Тип файла:");
		data.put("FC_UP", "Вверх");
		data.put("FC_NEW_DIRECTORY", "Новая папка");
		data.put("FC_LIST", "Список");
		data.put("FC_VIEW", "");
		data.put("FC_TABLE", "Таблица");
		data.put("FC_NAME", "Nмя");
		data.put("FC_SIZE", "Размер");
		data.put("FC_TYPE", "Тип");
		data.put("FC_DATE", "Дата");
		data.put("FC_ATTR", "Атрибуты");
		data.put("FC_ALL_FILTER", "");

		data.put("DIALOG_ABOUT_TITLE", "О программе");
		data.put("ABOUT", "<body style='font-size: 120%; text-align: center; wight: 350px'>"
				+ " <h1> Домашняя бухгалетрия</h1><p><img src = 'file:images/main.png'/></p>"
				+ "<p>Данную программу сделал<br/>Студент СПб ГУАП гр.5921</p>"
				+ "<br/><p>Пирогов Н.Н.</p>"
				+ "<p>2021г.</p>"
				+ "</body>");

		data.put("LABEL_TITLE", "Название: ");
		data.put("LABEL_CURRENCY", "Валюта:");
		data.put("LABEL_START_AMOUNT", "Начальный баланс: ");

		data.put("LABEL_DATE", "Дата");
		data.put("LABEL_ACCOUNT", "Счет");
		data.put("LABEL_ARTICLE", "Статья");
		data.put("LABEL_AMOUNT", "Сумма");
		data.put("LABEL_NOTICE", "Примечание");

		data.put("LABEL_FROM_ACCOUNT", "Откуда");
		data.put("LABEL_TO_ACCOUNT", "Куда");
		data.put("LABEL_FROM_AMOUNT", "Снято");
		data.put("LABEL_TO_AMOUNT", "Зачислено");

		data.put("LABEL_CODE", "Код");
		data.put("LABEL_RATE", "Курс");
		data.put("LABEL_ON", "Включено");
		data.put("LABEL_BASE", "Базовая");

		data.put("BALANCE_CURRENCIES", "Баланс по валютам");
		data.put("BALANCE", "Общий баланс");

		data.put("DATE", "Дата");
		data.put("ACCOUNT", "Счет");
		data.put("ARTICLE", "Статья");
		data.put("AMOUNT", "Сумма");
		data.put("NOTICE", "Примечание");
		data.put("LAST_TRANSACTIONS", "Последние транзакции");
		data.put("TITLE", "название");
		data.put("ACCOUNTS", "Счета");
		data.put("ARTICLES", "Статьи");
		data.put("TRANSACTIONS", "Транзакции");
		data.put("FROM_ACCOUNT", "Со счета");
		data.put("TO_ACCOUNT", "На счет");
		data.put("FROM_AMOUNT", "Списано");
		data.put("TO_AMOUNT", "Зачислено");
		data.put("TRANSFERS", "Переводы");
		data.put("CURRENCIES", "Валюты");
		data.put("CODE", "Код валюты");
		data.put("RATE", "Курс");
		data.put("ON", "Включена");
		data.put("BASE", "Базовая");
		data.put("CHAR_NO_DATA", "Нет данных за выбранный период");
		data.put("STATISTICS", "Статистика");
		data.put("CHART_INCOME", "Доходы по статьям");
		data.put("CHART_EXP", "Расходы по статьям");
		data.put("CHART_NO_DATA", "Нет данных для статистики");




		data.put("INPUT_LOGIN", "Введите логин:");
		data.put("INPUT_PASSWORD", "Введите пароль:");
		data.put("INPUT_PASSWORD_AGAIN", "Повторите пароль:");
		data.put("AUTHENTICATION", "Вход в систему");
		data.put("REGISTER", "Зарегистрироваться");
		data.put("REGISTRATION", "Регистрация");
		data.put("ENTER", "Войти");
		data.put("LOGIN_IS_EXIST_OR_PASS_DOESNT_MATCH", "Пользователь с таким логином уже существует или пароли не совпадают");


	}
}
