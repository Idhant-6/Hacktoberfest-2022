import heapq


class Vertex(object):
    def __init__(self, name):
        self.name = name
        self.adjacencyList = []
        self.visited = False

    # We define this method to return the name of the vertex whenever we call them
    def __str__(self):
        return self.name


class Edge(object):
    def __init__(self, weight, startVertex, targetVertex):
        self.weight = weight
        self.targetVertex = targetVertex
        self.startVertex = startVertex

    # This is the method helps python to understand how do we compare each edge
    def __lt__(self, other):
        selfPriority = self.weight
        otherPriority = other.weight
        return selfPriority < otherPriority

class PrimsJarnik(object):
    def __init__(self, unvisitedList):
        # We will have an unvisited list so that we can check nodes
        # This contains all the nodes
        self.unvisitedList = unvisitedList
        # We define the spanning tree
        self.spanningTree = []
        # The weight of the MST
        self.fullCost = 0
        # This is the heap for edge
        self.edgeHeap = []

    def CaculateSpanningTree(self, vertex):
        # First we remove the vertex from the unvisited list
        self.unvisitedList.remove(vertex)
        # We visit all the other nodes while the list is not empty
        while self.unvisitedList:
            # We iterate all through the neighbours of the vertex
            for edge in vertex.adjacencyList:
                # We check if the edge is unvisited
                if edge.targetVertex in self.unvisitedList:
                    # We push it to the heap
                    heapq.heappush(self.edgeHeap, edge)
            # We get the minimum edge in the minEdge
            minEdge = heapq.heappop(self.edgeHeap)
            # if the target of the min edge is in the unvisited list
            if minEdge.targetVertex in self.unvisitedList:
                # We append the edge to the MST
                self.spanningTree.append(minEdge)
                # We print it out just for our verification of what are the added edges
                print("Edge added to the spanning tree {} - {}".format(minEdge.startVertex, minEdge.targetVertex))
                # We increment the weight
                self.fullCost += minEdge.weight
                # We set the vertex to be the min edge's target vertex
                # We will visit that vertex and append the rest of the edges to the heap
                vertex = minEdge.targetVertex
                # Finally we remove the visited vertex from the unvisited list
                self.unvisitedList.remove(vertex)

    def getSpanningTree(self):
        return self.spanningTree

    def getCost(self):
        return self.fullCost


vertexA = Vertex("A")
vertexB = Vertex("B")
vertexC = Vertex("C")
vertexD = Vertex("D")
vertexE = Vertex("E")
vertexF = Vertex("F")
vertexG = Vertex("G")

edgeAB = Edge(2, vertexA, vertexB)
edgeBA = Edge(2, vertexB, vertexA)
edgeAE = Edge(5, vertexA, vertexE)
edgeEA = Edge(5, vertexE, vertexA)
edgeAC = Edge(6, vertexA, vertexC)
edgeCA = Edge(6, vertexC, vertexA)
edgeAF = Edge(10, vertexA, vertexF)
edgeFA = Edge(10, vertexF, vertexA)
edgeBE = Edge(3, vertexB, vertexE)
edgeEB = Edge(3, vertexE, vertexB)
edgeBD = Edge(3, vertexB, vertexD)
edgeDB = Edge(3, vertexD, vertexB)
edgeCD = Edge(1, vertexC, vertexD)
edgeDC = Edge(1, vertexD, vertexC)
edgeCF = Edge(2, vertexC, vertexF)
edgeFC = Edge(2, vertexF, vertexC)
edgeDE = Edge(4, vertexD, vertexE)
edgeED = Edge(4, vertexE, vertexD)
edgeDG = Edge(5, vertexD, vertexG)
edgeGD = Edge(5, vertexG, vertexD)
edgeFG = Edge(3, vertexF, vertexG)
edgeGF = Edge(3, vertexG, vertexF)

unvisitedList = [vertexA, vertexB, vertexC, vertexD, vertexE, vertexF, vertexG]

vertexA.adjacencyList.append(edgeAB)
vertexA.adjacencyList.append(edgeAC)
vertexA.adjacencyList.append(edgeAE)
vertexA.adjacencyList.append(edgeAF)
vertexB.adjacencyList.append(edgeBA)
vertexB.adjacencyList.append(edgeBD)
vertexB.adjacencyList.append(edgeBE)
vertexC.adjacencyList.append(edgeCA)
vertexC.adjacencyList.append(edgeCD)
vertexC.adjacencyList.append(edgeCF)
vertexD.adjacencyList.append(edgeDB)
vertexD.adjacencyList.append(edgeDC)
vertexD.adjacencyList.append(edgeDE)
vertexD.adjacencyList.append(edgeDG)
vertexE.adjacencyList.append(edgeEA)
vertexE.adjacencyList.append(edgeEB)
vertexE.adjacencyList.append(edgeED)
vertexF.adjacencyList.append(edgeFA)
vertexF.adjacencyList.append(edgeFC)
vertexF.adjacencyList.append(edgeFG)
vertexG.adjacencyList.append(edgeGD)
vertexG.adjacencyList.append(edgeGF)

algorithm = PrimsJarnik(unvisitedList)
algorithm.CaculateSpanningTree(vertexD)
print(algorithm.getCost())
