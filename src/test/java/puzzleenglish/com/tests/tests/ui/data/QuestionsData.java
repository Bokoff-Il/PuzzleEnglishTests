package puzzleenglish.com.tests.tests.ui.data;

public class QuestionsData {
    public Integer number;
    public String text;
    public String[] answers;

    public QuestionsData setFirstQuestions() {
        this.number = 1;
        this.text = "Как бы вы оценили свой уровень\nанглийского?";
        this.answers = new String[]{"Совсем ноль",
                "Начальный\nМогу рассказать о погоде",
                "Средний\nПонимаю смысл любимой песни",
                "Продвинутый\nСмотрю сериалы в оригинале"};
        return this;
    }

    public QuestionsData setSecondQuestions() {
        this.number = 2;
        this.text = "Сколько времени в день вы\nготовы\nзаниматься?";
        this.answers = new String[]{"10 минут\nНе спеша",
                "20 минут\nВ среднем темпе",
                "30 минут\nИнтенсивно",
                "45 минут\nМощно"};
        return this;
    }

    public QuestionsData setThirdQuestions() {
        this.number = 3;
        this.text = "Что вас мотивирует к\nизучению\nАнглийского?";
        this.answers = new String[]{"Путешествия",
                "Работа",
                "Учёба",
                "Саморазвитие",
                "Смотреть фильмы и читать\nкниги на английском",
                "Переезд за границу"};
        return this;
    }

    public QuestionsData setFourthQuestions() {
        this.number = 4;
        this.text = "Вам исполнилось 14 лет?";
        this.answers = new String[]{"Да", "Нет"};
        return this;
    }

    public QuestionsData setFifthQuestions() {
        this.number = 5;
        this.text = "Как вы хотите заниматься?";
        this.answers = new String[]{"Самостоятельно", "С преподавателем"};
        return this;
    }
}
