if __name__ == '__main__':
    s = input().split(' ')
    n = int(s[0])
    k = int(s[1])
    a = 0
    for l in range(1, min(n + 1, k)):
        count = 0
        ll = l
        while True:
            ll = ll * 2
            count = count + 1
            if ll >= k:
                a = a + (1 / (2**count))
                break
    if n < k:
        print(a * (1 / n))
    else:
        print((a * (1 / n)) + ((n - k + 1)/n))
