class Hash(object):
    def __init__(self):
        self.hashtable = []
        

    def hashing(self,word):
        num = 0
        for i in word:
           num += ord(i) ** 2
        
        self.hashtable.append(num)
        return num 

def main():
    H = Hash()
    print(H.hashing('123'))



if __name__ == "__main__":
    main()
