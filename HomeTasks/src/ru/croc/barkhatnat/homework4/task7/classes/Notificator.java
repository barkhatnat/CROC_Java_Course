package ru.croc.barkhatnat.homework4.task7.classes;

import ru.croc.barkhatnat.homework3.task5.intefaces.IHouseholdAppliance;

class Notificator {
    Order order;

    public Notificator(Order order) {
        this.order = order;
    }

    public String getNotification() {
        String ending = "ая";
        if (order.getClient().getIsMale()) {
            ending = "ый";
        }
        return String.format("Уважаем%s %s!\n" +
                        "\n" +
                        "Рады сообщить, что Ваш заказ %s готов к выдаче.\n" +
                        "\n" +
                        "Состав заказа:\n" +
                        "%s\n" +
                        "\n" +
                        "\n" +
                        "Сумма к оплате: %.3f₽\n" +
                        "\n" +
                        "Срок хранения заказа: до %td.%tm.%ty.\n" +
                        "\n" +
                        "\n" +
                        "С наилучшими пожеланиями, магазин “Кошки и картошки”\n", ending, order.getClient().getFullName(),
                order.getId(), getListOfItemsOutput(), order.getAmount(), order.getCollectedDateTime().plusWeeks(2),
                order.getCollectedDateTime().plusWeeks(2), order.getCollectedDateTime().plusWeeks(2));
    }

    private String getListOfItemsOutput() {
        StringBuilder output = new StringBuilder();
        for (IHouseholdAppliance item : order.getListOfItems()) {
            output.append(item).append("\n");
        }
        return output.toString();
    }
}
