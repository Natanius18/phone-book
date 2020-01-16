public enum ActionType {
    ADD(1), DELETE(2), UPDATE(3), SHOW(4), FIND(5), EXIT(0);
    private int index;
    ActionType(int index){
        this.index = index;
    }
    public int getIndex(){
        return index;
    }
}