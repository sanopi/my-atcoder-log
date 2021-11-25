if __name__ == '__main__':
    s = input()
    ys = 00
    ye = 99
    ms = 1
    me = 12
    s1 = int(s[0:2])
    s2 = int(s[2:])
    yymm = False
    mmyy = False
    if (ys <= s1 <= ye) and (ms <= s2 <= me):
        yymm = True
    if (ms <= s1 <= me) and (ys <= s2 <= ye):
        mmyy = True
    if yymm and mmyy:
        print('AMBIGUOUS')
    elif yymm and not mmyy:
        print('YYMM')
    elif mmyy and not yymm:
        print('MMYY')
    else:
        print('NA')
