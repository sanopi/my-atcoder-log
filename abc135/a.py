def main():
    inp = input().split(' ')
    a = int(inp[0])
    b = int(inp[1])
    if ((a + b) / 2).is_integer():
        print(str((a + b) // 2))
    else:
        print('IMPOSSIBLE')


if __name__ == '__main__':
    main()
