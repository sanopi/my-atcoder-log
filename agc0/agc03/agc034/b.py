# 不正解のコード
if __name__ == '__main__':
    s = input()
    maximum = len(s) - 1

    index = 0
    count = 0

    while True:
        index = s.find('ABC', index)
        if index == -1:
            print(str(count))
            exit()
        # BC
        bc_add = 4
        bc_count = 0
        while True:
            if index + bc_add <= maximum:
                if s[index + bc_add - 1:index + bc_add + 1] == 'BC':
                    bc_count += 1
                    bc_add += 2
                else:
                    break
            else:
                break
        # A
        a_hikizan = 1
        a_count = 0
        while True:
            if index - a_hikizan >= 0:
                if s[index - a_hikizan] == 'A':
                    a_count += 1
                    a_hikizan -= 1
                else:
                    break
            else:
                break
        # ABC
        abc_add = 5
        abc_count = 1
        while True:
            if index + abc_add <= maximum:
                if s[index + abc_add - 2:index + abc_add + 1] == 'ABC':
                    abc_count += 1
                    abc_add += 3
                else:
                    break
            else:
                break
        if abc_count > 1:
            bc_add2 = abc_add - 1
            while True:
                if index + bc_add2 <= maximum:
                    if s[index + bc_add2 - 1:index + bc_add2 + 1] == 'BC':
                        bc_count += 1
                        bc_add2 += 2
                    else:
                        break
                else:
                    break
        count += (abc_count + (abc_count if not a_count * bc_count == 0 else 0) + a_count + bc_count)
        index += 3
