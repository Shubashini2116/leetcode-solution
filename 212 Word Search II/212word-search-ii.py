class Solution:
    def findWords(self, board, words):
        trie = {}

        for word in words:
            node = trie
            for c in word:
                node = node.setdefault(c, {})
            node['#'] = word

        rows, cols = len(board), len(board[0])
        result = []

        def dfs(r, c, node):
            char = board[r][c]

            if char not in node:
                return

            nxt = node[char]

            if '#' in nxt:
                result.append(nxt.pop('#'))

            board[r][c] = '@'

            for dr, dc in [(1,0),(-1,0),(0,1),(0,-1)]:
                nr, nc = r+dr, c+dc
                if 0 <= nr < rows and 0 <= nc < cols and board[nr][nc] != '@':
                    dfs(nr, nc, nxt)

            board[r][c] = char

            if not nxt:
                node.pop(char)

        for i in range(rows):
            for j in range(cols):
                dfs(i,j,trie)

        return result