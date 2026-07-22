from collections import defaultdict, deque

class Solution:
    def findOrder(self, numCourses, prerequisites):
        graph = defaultdict(list)
        indegree = [0]*numCourses

        for a,b in prerequisites:
            graph[b].append(a)
            indegree[a]+=1

        q = deque([i for i in range(numCourses) if indegree[i]==0])
        ans=[]

        while q:
            node=q.popleft()
            ans.append(node)

            for nxt in graph[node]:
                indegree[nxt]-=1
                if indegree[nxt]==0:
                    q.append(nxt)

        return ans if len(ans)==numCourses else []