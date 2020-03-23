# @tortolala 18-mar-2020
# from memory_profiler import profile
import gc


class Node:
    def __init__(self, val):
        self.value = val
        self.left_child = None
        self.right_child = None

    def insert(self, data):
        if self.value == data:
            return False
        elif self.value > data:
            if self.left_child:
                return self.left_child.insert(data)
            else:
                self.left_child = Node(data)
                return True
        else:
            if self.right_child:
                return self.right_child.insert(data)
            else:
                self.right_child = Node(data)
                return True

    def find(self, key):
        if self.value == key:
            return True
        elif self.value > key:
            if self.left_child:
                return self.left_child.find(key)
            else:
                return False
        else:
            if self.right_child:
                return self.right_child.find(key)
            else:
                return False

    def traverse(self):
        # print(self.value)
        if self.left_child:
            self.left_child.traverse()
        if self.right_child:
            self.right_child.traverse()

    def find_min(self):
        if self.left_child:
            return self.left_child.find_min()
        else:
            return self.value

    def find_max(self):
        if self.right_child:
            return self.right_child.find_max()
        else:
            return self.value


    def delete(self, item):
        # Check if the self.value is the item, 
        # if it is not then recursively find it.
        if (self.value == item): # the value is the item
            if (not self.right_child) and (not self.left_child): 
                # si no existe el right child entonces:
                if (not self.left_child): # si no hay left del right retornar none 
                    return None 
                else: # si si hay left del right retornar ese
                    return self.left_child

            elif (not self.left_child):
                # si no existe el left retorno el right
                return self.right_child
            else:
                # necesitamos una var auxiliar para hacer la sustitución depués de eliminar.
                if self.right_child.left_child:
                    temp = self.right_child.find_min() 
                    
                else:
                    temp = self.right_child.value
                # el valor en cuestión es remplazado por el valor auxiliar
                self.value = temp
                # llamamos a la función de nuevo hasta que se cumpla que item sea == a self.value
                self.right_child.remove(temp)
                return self

                
        elif (self.value > item): # es para escoger cuál va a 
            # si existe el left child entonces recursivamente llamar a este método de nuevo 
            if self.left_child:
                self.left_child = self.left_child.delete(item)
            return self # this means it will return all the attributes aqui se retorna el self que ira a cuando finalmente se cumpla el val = item 
            
        else: # self.value < item
            if self.right_child:
                # si existe el right child entonces llamar recursivamente
                self.right_child = self.right_child.delete(item)
            return self



class Tree:
    def __init__(self):
        self.root = None

    def insert(self, data):
        if self.root:
            return self.root.insert(data)
        else:
            self.root = Node(data)
            return True

    def find(self, key):
        if self.root:
            return self.root.find(key)
        else:
            return False

    def traverse(self):
        if self.root:
            self.root.traverse()
        else:
            return False

    def find_min(self):
        if self.root:
            return self.root.find_min()
        else:
            return False

    def find_max(self):
        if self.root:
            return self.root.find_max()
        else:
            return False
    
    def delete(self,item):
        if (self.root):
            return self.root.delete(item)


def main():
    bst = Tree()
    #insertando datos
    bst.insert(1)
    bst.insert(2)
    bst.insert(3)
    bst.insert(4)
    bst.insert(5)
    bst.insert(6)
    bst.insert(7)
    bst.insert(8)
    bst.traverse()
    print(bst.find(8))
    print(bst.delete(8))
    print(bst.find(8))
    bst.traverse()
    # for obj in gc.get_objects():
    #     if isinstance(obj, Tree):
    #         print("Tree: ", obj)

    # for obj in gc.get_objects():
    #     if isinstance(obj, Node):
    #         print("Node: ", obj.value, obj)
    #         print("Right Child: ", obj.right_child)


if __name__ == "__main__":
    main()
