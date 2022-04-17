import java.util.Scanner;

class Main {

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax1 = (earnings) * 6 / 100;
        return tax1;
    }

    public static int differenceTaxs(int tax1, int tax) {
        int result = Math.abs(tax1 - tax);
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while (true) {
            System.out.println("Выберите операцию и введите её номер или введите end:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyExp = scanner.nextLine();
                    int money2 = Integer.parseInt(moneyExp);
                    spendings += money2;
                    break;
                case 3:
                    int tax = taxEarningsMinusSpendings(earnings, spendings);
                    int tax1 = taxEarnings(earnings);
                    int differenceTaxs = differenceTaxs(tax1, tax);
                    if (tax > tax1) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + tax1 + " рублей");
                        System.out.println("Налог на другой системе: " + tax + " рублей");
                        System.out.println("Экономия: " + differenceTaxs + " рублей");
                    } else {
                        System.out.println("Мы советуем вам: УСН Доходы минус расходы");
                        System.out.println("Ваш налог составит: " + tax + " рублей");
                        System.out.println("Налог на другой системе: " + tax1 + " рублей");
                        System.out.println("Экономия: " + differenceTaxs + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

}

