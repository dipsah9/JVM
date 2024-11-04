from __future__ import annotations
from typing import Any
import unittest

class MyNode:
    """Represents a node in the ADT List implementation MyList."""
    
    next: MyNode # Points to the next MyNode in this MyNodes MyList.
    data: Any # The data this MyNode stores.

    def __init__(self, data:Any=None, next:MyNode=None) -> None:
        """Initializes an empty Node object."""
        self.data = data
        self.next = next

    def get_next(self) -> MyNode:
        """Returns the next node object in the underlying MyList."""
        return self.next

    def get_data(self) -> Any:
        """Returns the data stored in this node."""
        return self.data

    def set_next(self, node:MyNode) -> None:
        """Sets this node's next MyNode to the given MyNode."""
        self.next = node

class MyList:
    """Implementation of the ADT List."""
    
    first:MyNode # Reference to the first MyNode in this MyList.
    length:int # Stores the length of this MyList.

    def __init__(self) -> None:
        """Initializes an empty MyList."""
        self.first = None
        self.length = 0

    def get(self, index:int) -> Any:
        """Returns the data of the MyNode at index 'index' in this MyList or the data of the first MyNode, if index is <0."""
        node = self.get_node(index)
        return node.get_data() if node else None

    def get_first(self) -> MyNode:
        """Returns the first MyNode in this MyList."""
        return self.first
    
    def get_last(self) -> MyNode:
        """Returns the last MyNode in this MyList."""
        return self.get_node(self.length-1)

    def prepend(self, data:Any) -> None:
        """Adds a MyNode with the given data at the beginning of this MyList."""
        self.add(index = 0, data = data)
    
    def append(self, data:Any) -> None:
        """Adds a MyNode with the given data at the end of this MyList."""
        self.add(index=self.length, data=data)

    def __len__(self) -> int:
        """Returns the length of this MyList."""
        return self.length

    def __str__(self) -> str:
        """Returns a string representation of this MyList."""
        result = ""
        curr = self.first
        while curr != None:
            result += f", {curr.get_data()}"
            curr = curr.get_next()
        return f"[{result[2:]}]"

    def get_node(self, index: int) -> Node:
        """Returns the Node at index 'index' in this LinkedList or the first Node, if index is <0."""
        if index < 0:
            return self.head  # Return the first node if index is negative
        
        current = self.head
        count = 0
        
        # Traverse the list to find the index
        while current:
            if count == index:
                return current  # Return the node at the specified index
            count += 1
            current = current.next
        
        return None  # If index is out of bounds

    def add(self, index: int, data: Any) -> None:
        """Adds a Node with the given data at the given index."""
        new_node = Node(data)  # Create a new node with the given data
        
        if index <= 0:  # If index is less than or equal to 0, insert at the beginning
            new_node.next = self.head  # Point new node to the current head
            self.head = new_node  # Update the head to the new node
            return
        
        current = self.head
        count = 0
        
        # Traverse the list to find the insertion point
        while current and count < index - 1:
            current = current.next
            count += 1
        
        if current is None:
            # If current is None, index is out of bounds, we can ignore or handle it
            print(f"Index {index} is out of bounds. Node not added.")
            return
        
        # Insert the new node
        new_node.next = current.next  # Link the new node to the next node
        current.next = new_node  # Link the current node to the new node


class MyUniqueList(MyList):
    """Implementation of the ADT UniqueList."""

    def add(self, index: int, data: Any) -> None:
        """Adds a Node with the given data at the given index."""
        new_node = Node(data)  # Create a new node with the given data

        if index <= 0:  # If index is less than or equal to 0, insert at the beginning
            new_node.next = self.head  # Point the new node to the current head
            self.head = new_node  # Update the head to the new node
            return

        current = self.head
        count = 0
        
        # Traverse the list to find the insertion point
        while current and count < index - 1:
            current = current.next
            count += 1

        if current is None:
            # If current is None, the index is greater than the list length,
            # so we can append the new node to the end of the list.
            self.append(data)
            return

        # Insert the new node in the appropriate position
        new_node.next = current.next  # Link the new node to the next node
        current.next = new_node  # Link the current node to the new node

# Unit Tests
class TestExercise4(unittest.TestCase):
    def test_my_list_get(self):
        l = MyList()
        l.first=MyNode(1, MyNode(3, MyNode(3, MyNode(7, None))))
        l.length = 4
        self.assertEqual(l.get_first().get_data(), 1)
        self.assertEqual(l.get(1), 3)
        self.assertEqual(l.get(2), 3)
        self.assertEqual(l.get_last().get_data(), 7)

    def test_my_list_append(self):
        l = MyList()
        l.append(42)
        l.append("foo")
        l.append(None)
        l.append(None)
        self.assertEqual(str(l), "[42, foo, None, None]")

    def test_my_list_prepend(self):
        l = MyList()
        l.prepend(42)
        l.prepend("foo")
        l.prepend(None)
        l.prepend(None)
        self.assertEqual(str(l), "[None, None, foo, 42]")

    def test_my_list_add(self):
        l = MyList()
        l.add(0, 3)
        l.add(1, 3)
        l.add(0, 1)
        l.add(3, 7)
        self.assertEqual(str(l), "[1, 3, 3, 7]")

    def test_my_list_add_out_of_bounds(self):
        l = MyList()
        l.add(0, "in")
        l.add(2, "out")
        self.assertEqual(str(l), "[in]")

    def test_my_list_all(self):
        l = MyList()
        l.append("am")
        l.prepend("hc")
        l.append(" t")
        l.add(2, "eg")
        l.add(0, "t")
        l.add(42, None)
        l.append("G")
        l.prepend("!")
        l.add(6, "u")
        self.assertEqual(str(l).replace(", ",""), "[!thcameg tuG]")
        self.assertEqual(l.get(0), "!")

class TestExercise5(unittest.TestCase):
    def test_my_unique_list_append(self):
        l = MyUniqueList()
        l.append(42)
        l.append("foo")
        l.append(None)
        l.append(None)
        l.append("foo")
        self.assertEqual(str(l), "[42, foo, None]")

    def test_my_unique_list_prepend(self):
        l = MyUniqueList()
        l.prepend(42)
        l.prepend("foo")
        l.prepend(None)
        l.prepend(None)
        l.prepend("foo")
        self.assertEqual(str(l), "[None, foo, 42]")

    def test_my_unique_list_add(self):
        l = MyUniqueList()
        l.add(0, 3)
        l.add(1, 3)
        l.add(0, 1)
        l.add(2, 7)
        self.assertEqual(str(l), "[1, 3, 7]")

    def test_my_unique_list_add_out_of_bounds(self):
        l = MyUniqueList()
        l.add(0, "in")
        l.add(2, "out")
        self.assertEqual(str(l), "[in]")
        
    def test_my_unique_list_get(self):
        l = MyUniqueList()
        l.add(0, 3)
        l.add(1, 3)
        l.add(0, 1)
        l.add(2, 7)
        self.assertEqual(l.get_first().get_data(), 1)
        self.assertEqual(l.get(1), 3)
        self.assertEqual(l.get_last().get_data(), 7)

    def test_my_unique_list_all(self):
        l = MyUniqueList()
        l.append("am")
        l.prepend("hc")
        l.append(" t")
        l.add(2, "eg")
        l.add(0, "t")
        l.prepend("hc")
        l.add(42, None)
        l.append("G")
        l.add(3, "t")
        l.prepend("!")
        l.append(" t")
        l.add(6, "u")
        self.assertEqual(str(l).replace(", ",""), "[!thcameg tuG]")
        self.assertEqual(l.get(0), "!")

if __name__ == '__main__':
    runner = unittest.TextTestRunner()
    print("---------------- Test Exercise 4 ----------------")
    runner.run(unittest.TestLoader().loadTestsFromTestCase(TestExercise4))
    print("---------------- Test Exercise 5 ----------------")
    runner.run(unittest.TestLoader().loadTestsFromTestCase(TestExercise5))