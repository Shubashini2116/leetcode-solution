class Solution:
    def combinationSum3(self, k, n):
        ans=[]

        def backtrack(start, path, total):
            if len(path)==k and total==n:
                ans.append(path[:])
                return

            if len(path)>k or total>n:
                return

            for i in range(start,10):
                backtrack(i+1,path+[i],total+i)

        backtrack(1,[],0)
        return ans