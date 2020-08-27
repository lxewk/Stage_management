package nl.kortekaas.Stagemanagement.domain;

public class Todo {

    private Item item;
    private String doneBy;
    private char priority;
    private boolean check;

    public Todo(Item item) {
        this.item = item;
        this.doneBy = doneBy;
        this.priority = ' ';
        this.check = false;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }

    public char getPriority() {
        return priority;
    }

    public void setPriority(char priority) {
        this.priority = priority;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
