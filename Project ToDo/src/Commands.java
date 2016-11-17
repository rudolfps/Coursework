/**
 * Created by gabkamabka on 2016.11.17..
 */
public class Commands {
    /**
     * Provides a very simple ToDoList.  New items can be added at the end
     * and removed from any other position.  ToDoList tasks are indexed
     * starting at 1 (not 0).
     * <p>
     * Demonstrates use of arrays and object-oriented programming (OOP).
     *
     * @author Puskás Rudolf
     */


    //instance variables
    private String[] todo; //storage of tasks
    private int count;     //how many tasks have been added to todo


    /**
     *  Builds a new, empty ToDoList.  Current max capacity is 5.
     */
    public Commands() {
        this.todo = new String[5];
        this.count = 0;
    }

    /**
     * Adds the given item to this ToDoList.  Returns true if successfully
     * added, or false if not (such as when the list is full).
     */
    public boolean add(String item) {
        if (this.count == this.todo.length) {
            return false;  //can't add to full list
        }else {
            this.todo[count] = item;
            this.count++;
            return true;
        }
    }

    /**
     * Returns how many items are currently stored in this list.
     */
    public int getSize() {
        return count;
    }

    /**
     * Removes the item at the given 1-based index in this list.
     * Returns the removed item, or null if the given index did not correspond
     * to a valid item.
     */
    public String remove(int index) {
        if (index < 1 || index > this.count) {
            return null;  //no such element
        }else {
            index--;  //convert to 0-based indexing used by array
            String deleted = this.todo[index];
            //delete by shifting everything down into removed item's space
            for (int i = index; i < this.count - 1; i++) {
                this.todo[i] = this.todo[i + 1];
            }
            this.count--;  //removed an element
            return deleted;
        }
    }

    /**
     * Returns a String representation of this ToDoList.
     * Specifically, "TODO:" followed by a numbered list of tasks.
     */
    public String toString() {
        String output = "TODO:\n";
        for (int i = 0; i < this.count; i++) {
            output += (i + 1) + ". " + this.todo[i] + "\n";
        }
        return output;
    }



    /**
     * Provides a simple menu-based interface for the user to use a single
     * ToDoList.
     */
}
