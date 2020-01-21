public enum ActionType {
    ADD(1), DELETE(2), UPDATE(3), SHOW(4), FIND(5), EXIT(0) , SAVE(6), SORT(7),
    Name(1), Surname(2), Phone(3), Birthday(4),
    byName(1), byFirstLetters(2), byLastDigitsOfNumber(3);
    private int index;
    ActionType(int index){
        this.index = index;
    }
    public int getIndex(){
        return index;
    }
}