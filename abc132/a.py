def main():
    s = input()
    count = s.count(s[0])
    if count == 2:
        strip = s.strip(s[0])
        if strip.count(strip[0]) == 2:
            print('Yes')
        else:
            print('No')
    else:
        print('No')


if __name__ == '__main__':
    main()
