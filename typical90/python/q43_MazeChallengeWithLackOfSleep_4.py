from collections import deque

inf = 1000000000
xx = [1, 0, -1, 0]
yy = [0, 1, 0, -1]


def main():
    h, w = map(int, input().split(" "))
    rs, cs = map(int, input().split(" "))
    rt, ct = map(int, input().split(" "))
    rs -= 1
    cs -= 1
    rt -= 1
    ct -= 1

    def valid(x, y):
        return 0 <= x < h and 0 <= y < w

    def get_index(x, y):
        return x*w+y

    g = []
    for i in range(h):
        g.append(input())
    costs = [[inf]*(w*h) for j in range(4)]
    for i in range(4):
        costs[i][get_index(rs, cs)] = 0
    q = deque()
    for i in range(4):
        nx = rs + xx[i]
        ny = cs + yy[i]
        if valid(nx, ny) and g[nx][ny] == ".":
            q.append((get_index(nx, ny), i))
            costs[i][get_index(nx, ny)] = 0

    end_index = get_index(rt, ct)

    while q:
        index, d = q.popleft()
        if index == end_index:
            break
        x, y = divmod(index, w)
        cost = costs[d][index]
        for i in range(4):
            nx = x + xx[i]
            ny = y + yy[i]
            if valid(nx, ny) and g[nx][ny] == "." and abs(i-d) != 2:
                new_cost = cost + (0 if i == d else 1)
                nindex = get_index(nx, ny)
                if costs[i][nindex] > new_cost:
                    costs[i][nindex] = new_cost
                    if i == d:
                        q.appendleft((nindex, i))
                    else:
                        q.append((nindex, i))
    ans = inf
    for i in range(4):
        ans = min(ans, costs[i][end_index])
    print(ans)


if __name__ == '__main__':
    main()
