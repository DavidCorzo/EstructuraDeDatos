from BellMan import Node
from BellMan import BellManFord
from BellMan import Edge

def main():
    node_1 = Node("A")
    node_2 = Node("B")
    node_3 = Node("C")
    node_4 = Node("D")

    edge_1 = Edge(1,node_1,node_2)
    edge_2 = Edge(1,node_2,node_3)
    edge_3 = Edge(1,node_3,node_4)
    edge_4 = Edge(4,node_3,node_2)
    edge_5 = Edge(300,node_1,node_4)


    node_1.adjecencylist.append(edge_1)
    node_1.adjecencylist.append(edge_2)
    node_2.adjecencylist.append(edge_3)
    node_3.adjecencylist.append(edge_4)
    node_3.adjecencylist.append(edge_2)

    vertexList = [node_1,node_2,node_3,node_4]
    edgeList = [edge_1,edge_2,edge_3,edge_4,edge_5]


    sp = BellManFord()
    sp.calcShortestPath(vertexList,edgeList,node_1)
    sp.getShortestPathTo(node_4)

if __name__ == "__main__":
    main()
