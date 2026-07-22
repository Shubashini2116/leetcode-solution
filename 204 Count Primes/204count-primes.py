class Solution:
    def countPrimes(self, n):
        if n <= 2:
            return 0

        prime = [True] * n
        prime[0] = False
        prime[1] = False

        p = 2
        while p * p < n:
            if prime[p]:
                i = p * p
                while i < n:
                    prime[i] = False
                    i += p
            p += 1

        return sum(prime)