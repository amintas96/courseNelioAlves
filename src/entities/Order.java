package entities;

import entities.enuns.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> orderItem = new ArrayList<>();


    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void addItem(OrderItem orderItem) {
        this.orderItem.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        this.orderItem.remove(orderItem);
    }

    public double total (){
        double sum = 0.0;
        for(OrderItem orderItem : orderItem){
            sum += orderItem.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Order moment: ");
        sb.append(sdf.format(moment)+ "\n");
        sb.append("Order Status: ");
        sb.append(this.status + "\n");
        sb.append("Client: ");
        sb.append(this.client + "\n");
        sb.append("Order Items: \n");
        for(OrderItem orderItem: orderItem){

            sb.append(orderItem +"\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));

        return sb.toString();

    }
}
