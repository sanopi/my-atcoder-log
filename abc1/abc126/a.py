if __name__ == '__main__':
    args = input().split(' ')
    s = input()
    k = int(args[1])
    n = int(args[0])
    if k == 1:
        print(s[k - 1].lower() + s[k:])
    elif k == n:
        print(s[0:k-1] + s[k - 1].lower())
    else:
        print(s[0:k-1] + s[k - 1].lower() + s[k:])
