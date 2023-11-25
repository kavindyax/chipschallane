public class ItemLayer {
    class Item {
        // Common properties
        private String name;
        private int row;
        private int col;

        // Constructor to initialize item properties
        public Item(String name, int row, int col) {
            this.name = name;
            this.row = row;
            this.col = col;
        }

        // Getters
        // Retrieve the name of the item
        public String getName() {
            return name;
        }

        // Retrieve the row coordinate of the item
        public int getRow() {
            return row;
        }

        // Retrieve the column coordinate of the item
        public int getCol() {
            return col;
        }


        // Class for Computer Chips
        class Chip extends Item {
            // Constructor to create a Chip at a specific location
            public Chip(int row, int col) {
                // Calls the constructor of the base class (Item) with the name "Chip"
                super("Chip", row, col);
            }
        }

        // Class for Keys
        class Key extends Item {
            private String color; // Color of the key

            // Constructor to create a Key with a specific color at a certain location
            public Key(String color, int row, int col) {
                // Calls the constructor of the Item class with the name "Key" and the specified location
                super("Key", row, col);
                this.color = color;
            }

            // Getter to retrieve the color of the key
            public String getColor() {
                return color;
            }
        }

        // Class for the Item Layer
        class ItemLayer {
            private Item[][] cells; // Matrix to represent the item layer
            private Map<String, Key> keyMap; // Map to store keys and their colors

            // Constructor to create an ItemLayer with a specified number of rows and columns
            public ItemLayer(int numRows, int numCols) {
                cells = new Item[numRows][numCols];
                keyMap = new HashMap<>();

            }

            // Get the item at a specific cell
            public Item getItem(int row, int col) {
                return cells[row][col];
            }

            // Set an item at a specific cell
            public void setItem(int row, int col, Item item) {
                cells[row][col] = item;
                // If the item is a Key, add it to the keyMap for easy retrieval by color
                if (item instanceof Key) {
                    Key key = (Key) item;
                    keyMap.put(key.getColor(), key);
                }
            }

            // Retrieve a key by its color from the keyMap
            public Key getKeyByColor(String color) {
                return keyMap.get(color);
            }
        }

    }
