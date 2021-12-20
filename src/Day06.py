import os
from collections import defaultdict


def solution1(l):
    for day in range(80):
        temp_list = []
        for fish in l:
            new_timer = fish -1
            if new_timer == -1:
                temp_list.append(6)
                temp_list.append(8)
            else:
                temp_list.append(new_timer)
        l = temp_list
        temp_list = []
    return len(l)



def update_fishes(fishes):
    new_fish_dict = defaultdict(int)
    for timer, num_of_fish in fishes.items():
        if timer == 0:
            timer = 7
            new_fish_dict[8] += num_of_fish
        new_fish_dict[timer - 1] += num_of_fish
    return new_fish_dict


def solution2(fishes):
    fish_dict = fishes.copy()
    for day in range(256):
        print(day)
        fish_dict = update_fishes(fish_dict)
    return sum(fish_dict.values())


if __name__ == "__main__":
    dir = os.path.abspath(os.path.dirname(__file__))
    with open(os.path.join(dir, "Day06.txt")) as file:
        _input = file.read().splitlines()

    list_input = [int(i) for i in _input[0].split(',')]
    print(solution1(list_input))

    lanternfishes = list(map(int, _input[0].split(",")))
    fish_dict = {timer: lanternfishes.count(timer) for timer in set(lanternfishes)}
    print(solution2(fish_dict))
