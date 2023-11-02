package ru.croc.barkhatnat.homework4.task7.classes;

import ru.croc.barkhatnat.homework3.task5.intefaces.IHouseholdAppliance;
import ru.croc.barkhatnat.homework4.task7.interfaces.NotificatorInterface;

import java.time.format.DateTimeFormatter;

class Notificator implements NotificatorInterface {
    Order order;

    public Notificator(Order order) {
        this.order = order;
    }

    public String getNotification() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Уважаем");
        if (order.getClient().getIsMale()) {
            stringBuilder.append("ый ");
        } else {
            stringBuilder.append("ая ");
        }
        stringBuilder.append(order.getClient().getFullName()).append("!");
        stringBuilder.append("\n\n");
        stringBuilder.append("Рады сообщить, что Ваш заказ ");
        stringBuilder.append(order.getId());
        stringBuilder.append(" готов к выдаче.\n\nСостав заказа:");
        stringBuilder.append(getListOfItemsOutput());
        stringBuilder.append("\n\nСумма к оплате: ");
        stringBuilder.append(order.getFormattedAmount());
        stringBuilder.append("\n\n\nСрок хранения заказа: до ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        stringBuilder.append(order.getCollectedDateTime().plusWeeks(2).format(formatter));
        stringBuilder.append("\n\n\nС наилучшими пожеланиями, магазин “Кошки и картошки”\n");
        return stringBuilder.toString();
    }

    private String getListOfItemsOutput() {
        StringBuilder output = new StringBuilder();
        for (IHouseholdAppliance item : order.getListOfItems()) {
            output.append(item).append("\n");
        }
        return output.toString();
    }
}
