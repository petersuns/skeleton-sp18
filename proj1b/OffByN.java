public class OffByN implements CharacterComparator {
    int number;
    public OffByN(int N){
        number=N;
    }
    @Override
    public boolean equalChars(char x, char y){
        return (x-y) == number || (x-y) == -number;
    };
}