def is_palindrome(s):
    print("String to check: ", s, ". Length of string: ", len(s), sep='')

    return ("The pointers have either reached the same index, or have crossed each other, hence we don't need to look further.")


# Driver code
def main():
    test_cases = ["RACECAR", "ABBA", "TART"]
    i = 1
    for s in test_cases:
        print("Test Case #", i)
        print(is_palindrome(s))
        print("-" * 100, end="\n\n")
        i = i + 1

if __name__ == '__main__':
    main()
