public class MyArrayList<T> {
    private int currentSize=0;

    private int arrayCapacity = 0;

    private int currentIndex = 0;
    private Object[] array = null;
    private  Object[] temp = null;

    public MyArrayList() {
        array = new Object[arrayCapacity];
    }

    public MyArrayList(int arrayCapacity) {
        array = new Object[arrayCapacity];
        this.arrayCapacity = arrayCapacity;
    }
    public void add(Object value) {
         currentSize++;
        if (currentSize < arrayCapacity) {
            array[currentIndex++] = value;
        } else {
            arrayCapacity++;

            Object[] temp = new Object[arrayCapacity];

            System.arraycopy(array, 0, temp, 0, array.length);

            array = temp;

            array[currentIndex++] = value;
        }
    }
       public Object get(int index) {
        if (index > currentSize - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return array[index];
    }
      public void remove(int index) {

        if (currentSize == 0) {
              System.out.println("Already empty!");
              return;
        }

        if (index > currentSize - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        for (int i = index; i < currentSize - 1; i++) {
            array[i] = array[i + 1]; // перезаписываем предыдущие данные
        }
        currentSize--;
        currentIndex--;
    }
    public void clear() {
        array = null;
        currentSize =0;
        currentIndex =0;
        arrayCapacity = 0;

    }
    public Integer size() {
        return currentSize;
    }

     public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList<>();
// add(Object value) добавляет элемент в конец
         for (int i = 0; i < 13; i++) {
             list.add(i);
         }
// size() возвращает размер коллекции
         System.out.println("Размер коллекции = " + list.size());

// get(int index) возвращает элемент под индексом
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
// remove(int index) удаляет элемент под индексом
        list.remove(10);

         System.out.println("\n---------------------------------------------");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("index:" + i + ";value:" + list.get(i));
        }
//  clear() очищает коллекцию
         list.clear();

         for (int i = 0; i < list.size(); i++) {
             System.out.println("index:" + i + ";value:" + list.get(i));
         }
    }
}
