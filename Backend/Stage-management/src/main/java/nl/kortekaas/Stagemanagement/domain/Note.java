package nl.kortekaas.Stagemanagement.domain;

public class Note {

    private Role activeRole;
    private Role receiverRole;
    private Todo activeTODO;
    private char priority;


    public Note(Role activeRole, Role receiverRole, Todo activeTODO) {
        this.activeRole = activeRole;
        this.receiverRole = receiverRole;
        this. activeTODO = activeTODO;
        this.priority = ' ';
    }

    public void sendNote(Role receiverRole, Role activeRole) {
        System.out.println(receiverRole + " You've got a note");
        int toSend = receiverRole.getReceivedNote();
        receiverRole.setReceivedNote(toSend);
    }

    public Role getActiveRole() {
        return activeRole;
    }

    public void setActiveRole(Role activeRole) {
        this.activeRole = activeRole;
    }

    public Role getReceiverRole() {
        return receiverRole;
    }

    public void setReceiverRole(Role receiverRole) {
        this.receiverRole = receiverRole;
    }

    public Todo getActiveTODO() {
        return activeTODO;
    }

    public void setActiveTODO(Todo activeTODO) {
        this.activeTODO = activeTODO;
    }

    public char getPriority() {
        return priority;
    }

    public void setPriority(char priority) {
        this.priority = priority;
    }
}
