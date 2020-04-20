import sys 

class BellManFord(object):
    MAS_CYCLE = False 
    # edges can have negative weights
    # this means that we can have an infinite loop because of the negative edge ewights.

    def calcShortestPath(self,vertexList,edgeList,startVertex):
        startVertex.minDistance = 0

        for i in range(0,len(vertexList)-1):
            for edge in edgeList:
                u = edge.startVertex 
                v = edge.targetVertex
                newDistance = u.minDistance + edge.weight

                if newDistance < v.minDistance:
                    v.minDistance = newDistance
                    v.predecesor = u 

        for edge in edgeList:
            if self.hasCycle(edge):
                print("Negative cycle detected")
                self.MAS_CYCLE = True 
                return 

    def hasCycle(self,edge):
        if (edge.startVertex.minDistance + edge.weight) < (edge.targetVertex.minDistance):
            return True
        else:
            return False
    
    def getShortestPathTo(self,targetVertex):
        print("Shortest path to targetVertex: ", targetVertex.minDistance)


class Edge(object):
    def __init__(self,weight,startVertex,targetVertex):
        self.weight = weight 
        self.startVertex = startVertex
        self.targetVertex = targetVertex



class Node(object):
    def __init__(self,name):
        self.name = name
        self.visited = False
        self.adjecencylist = []
        self.predecesor = None 
        self.minDistance = sys.maxsize
