from collections import defaultdict, deque

class Solution:
    def canFinish(self, numCourses, prerequisites):
        graph = defaultdict(list)
        indegree = [0] * numCourses

        for a, b in prerequisites:
            graph[b].append(a)
            indegree[a] += 1

        q = deque([i for i in range(numCourses) if indegree[i] == 0])
        count = 0

        while q:
            node = q.popleft()
            count += 1

            for nxt in graph[node]:
                indegree[nxt] -= 1
                if indegree[nxt] == 0:
                    q.append(nxt)

        return count == numCourses