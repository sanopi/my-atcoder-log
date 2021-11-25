if __name__ == '__main__':
    split = input().split(' ')
    n = int(split[0]) - 1
    a = int(split[1]) - 1
    b = int(split[2]) - 1
    c = int(split[3]) - 1
    d = int(split[4]) - 1
    s = input()
    isOK = False
    if c < d:
        isOK = not ('##' in s[a:c] or '##' in s[b:d])
    else:
        isOK = (not ('##' in s[a:c] or '##' in s[b:d])) and ('...' in s[b-1:d+2])
    print('Yes' if isOK else 'No')
