# March 29, 2020

from typing import Tuple
from math import floor


class MaxHeap:
    def __init__(self):
        self.heap = []

    # Utilities:

    def get_parent(self, i: int) -> int:
        return floor((i - 1) / 2)

    def get_left_child(self, i: int) -> int:
        return 2 * i + 1

    def get_right_child(self, i: int) -> int:
        return 2 * i + 2

    def has_parent(self, i: int) -> bool:
        return self.get_parent(i) >= 0

    def has_left_child(self, i: int) -> bool:
        return self.get_left_child(i) < len(self.heap)

    def has_right_child(self, i: int) -> bool:
        return self.get_right_child(i) < len(self.heap)

    def swap(self, i: int, j: int) -> None:
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def heapify_up(self, i: int) -> None:
        while self.has_parent(i) and self.heap[i] > self.heap[self.get_parent(i)]:
            self.swap(i, self.get_parent(i))
            i = self.get_parent(i)

    def heapify_down(self, i: int) -> None:
        while(self.has_left_child(i)):
            max_child_index = self.get_max_child_index(i)
            if not max_child_index:
                break
            if(self.heap[i] < self.heap[max_child_index]):
                self.swap(i, max_child_index)
                i = max_child_index
            else:
                break

    def get_max_child_index(self, i: int) -> any:
        if self.has_left_child(i):
            left_c = self.get_left_child(i)
            if self.has_right_child(i):
                right_c = self.get_right_child(i)
                if self.heap[left_c] > self.heap[right_c]:
                    return left_c
                else:
                    return right_c
            else:
                return left_c
        else:
            return False

    # Main methods:

    def print_heap(self) -> None:
        return self.heap

    def max_value(self) -> int:
        return self.heap[0]

    def insert(self, value: int) -> None:
        self.heap.append(value)
        self.heapify_up(len(self.heap) - 1)

    def delete(self) -> Tuple[bool, any]:
        if len(self.heap) == 0:
            return [False, None]
        last_index = len(self.heap) - 1
        self.swap(0, last_index)
        deleted_root = self.heap.pop()
        self.heapify_down(0)
        return [True, deleted_root]
    
    def DFS(self, num, i=0):
        ''' 
        This method is used to find a determined value in a heap, 
        Takes as an argument the number to find then it returns at which index of the array it lies.   
        ''' 
        if self.get_left_child(i) < len(self.heap): # no index out bounds
            lc = self.DFS(num=num, i=self.get_left_child(i))
            if lc:
                return lc
        if self.get_right_child(i) < len(self.heap):
            rc = self.DFS(num=num, i=self.get_right_child(i))
            if rc:
                return rc
        # El número es el head
        if num == self.heap[i]:
            return i
        # El numero no es
        else:
            return False
    
    def BFS(self, num):
        '''
        if head is not None: # equivalent in python
            queue = []
            queue.append(head)

            while True:
                elemento = cola.pop()
                elemento es el numero que buscas
                SI
                    return el número que buscas
                    break
                No
                    cola.append(child left)
                    cola.append(child right)
            if not x
                elemento es el que buscas
            else    
                elemento no existe
        '''
        # if len(self.heap) != 0:
        queue = []
        queue.append(0)


        while True: 
            if len(self.heap) == 0:
                return False    
            element = queue.pop(0)
            if self.heap[element] == num:
                return element
            else:
                if self.get_left_child(element) <= len(self.heap):
                    queue.append(self.get_left_child(element))
                if self.get_right_child(element) <= len(self.heap):
                    queue.append(self.get_right_child(element))

        return False 

# Main process:


def main():
    heap = MaxHeap()
    initial_values = [3, 5, 7, 1, 10, 8, 4, 11, 13, 14, 16, 20, 100]
    for i in initial_values:
        heap.insert(i)

    hh = heap.print_heap()
    print(hh)
    for ii in hh:
        print("From the DFS: ",heap.DFS(ii),ii) # :) 
        print("From the BFS: ",heap.BFS(ii), ii)



if __name__ == "__main__":
    main()
