def main():
    n = input()
    ps = input().split(' ')
    count = 0
    for i in range(1, len(ps) - 1):
        if int(ps[i]) > min(int(ps[i - 1]), int(ps[i + 1])):
            if int(ps[i]) <= max(int(ps[i - 1]), int(ps[i + 1])):
                count += 1
    print(str(count))


if __name__ == '__main__':
    main()
