import com.sun.jdi.CharType;
import org.w3c.dom.Text;
import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.awt.SystemColor.text;

// Перечисление меток для текста;
enum Label {
  SPAM,
  NEGATIVE_TEXT,
  TOO_LONG,
  OK
}

// Интерфейс для анализаторов текста;
interface TextAnalyzer {
  Label processText(String text); // Метод для обработки текста;
}

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  // Метод для проверки меток по набору анализаторов

  public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
    // Проходим по каждому анализатору
    for (TextAnalyzer analyzer : analyzers) {
      // Обрабатываем текст анализатором
      Label label = analyzer.processText(text);
      // Если метка не OK, возвращаем ее
      if (label != Label.OK) {
        return label;
      }
    }
    return Label.OK; // Если все анализаторы вернули OK, возвращаем OK
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    // Создаем массив анализаторов
    TextAnalyzer[] analyzers = new TextAnalyzer[]{
            new SpamAnalyzer(new String[]{"спам", "реклама", "рекламой"}), // Анализатор спама
            new NegativeTextAnalyzer(), // Анализатор негативного содержания
            new TooLongTextAnalyzer(50) // Анализатор слишком длинных комментариев
    };

    // Примеры текстов
    String[] texts = {
            "Это обычный комментарий",
            "Это комментарий с рекламой",
            "Это комментарий с негативным смайликом :(",
            "Это комментарий, который слишком длинный и не соответствует правилам"
    };

    // Проверяем каждый текст по набору анализаторов и выводим метку
    for (String text : texts) {
      Label label = checkLabels(analyzers, text);
      System.out.println("Label for '" + text + "': " + label);
    }
  }

  // Класс для анализа спама;
  public static class SpamAnalyzer extends KeywordAnalyzer {
    private final String[] keywords; // Массив для ключевых слов "спама";

    public SpamAnalyzer(String[] keywords) {
      this.keywords = keywords;
    }

    @Override
    public String[] getKeywords() {
      return keywords;
    }

    @Override
    public Label getLabel() {
      return Label.SPAM;
    }
  }

  // Класс для анализа негативных ключевых слов;
  public static class NegativeTextAnalyzer extends KeywordAnalyzer {
    @Override
    public String[] getKeywords() {
      return new String[] {":(", "=(", ":|"}; // Массив с смайликами негативного характера;
    }

    @Override
    public Label getLabel() {
      return Label.NEGATIVE_TEXT;
    }
  }

  // Класс для анализа слишком длинным комментариев;
  public static class TooLongTextAnalyzer implements TextAnalyzer {
    private final int maxLength; // Максимальная длина текста;

    public TooLongTextAnalyzer(int maxLength) {
      this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
      if (text.length() > maxLength) {
        return Label.TOO_LONG; // Если текст слишком длинный, то возвращаем метку TOO_LONG;
      }
      return Label.OK; // Иначе возвращаем OK;
    }
  }
}

// Абстрактный класс для анализа на основе ключевых слов;
abstract class KeywordAnalyzer implements TextAnalyzer {
  public abstract String[] getKeywords(); // метод для получения ключевых слов;

  public abstract Label getLabel(); // Метод для получения метки;

  public Label processText(String text) {
    // Проверяем наличие ключевых слов;
    for (String keyword : getKeywords()) {
      if (text.contains(
          keyword)) { // contains - проверяет наличие указанной последовательности символов;
        return getLabel(); // Если ключевое слово было найдено, то возвращается метка;
      }
    }
    return Label.OK; // Если найдено не было, то возвращает "OK";
  }
}
