import os


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y


class Line:
    def __init__(self, x1, x2, y1, y2):
        self.x1 = int(x1)
        self.x2 = int(x2)
        self.y1 = int(y1)
        self.y2 = int(y2)

    def get_all_points_in_line(self):
        points = []
        start = (self.x1, self.y1)
        end = (self.x2, self.y2)
        get_step = lambda l: 0 if l[0] == l[1] else (l[1] - l[0]) / abs(l[1] - l[0])
        x_step = get_step((start[0], end[0]))
        y_step = get_step((start[1], end[1]))
        distance = max(abs(end[0] - start[0]), abs(end[1] - start[1]))
        for i in range(distance + 1):
            x = start[0] + i * x_step
            y = start[1] + i * y_step
            points.append(Point(int(x), int(y)))
        return points

    def get_all_points_in_straignt_line(self):
        points = []
        xs = None
        ys = None
        if self.x1 == self.x2:
            if self.y1 > self.y2:
                ys = list(range(self.y2, self.y1 + 1))
            elif self.y2 > self.y1:
                ys = list(range(self.y1, self.y2 + 1))
        elif self.y1 == self.y2:
            if self.x1 > self.x2:
                xs = list(range(self.x2, self.x1 + 1))
            elif self.x2 > self.x1:
                xs = list(range(self.x1, self.x2 + 1))
        if xs:
            for x in xs:
                points.append(Point(x, self.y1))
        if ys:
            for y in ys:
                points.append((Point(self.x1, y)))
        return points


def solution1(l):
    straight_lines = []
    points = []
    rows, cols = (1000, 1000)
    hits = [[0] * rows for _ in range(cols)]
    score = 0
    for raw_line in l:
        line = get_line_if_straight(raw_line)
        if line:
            straight_lines.append(line)
    for line in straight_lines:
        points = points + line.get_all_points_in_straignt_line()
    for point in points:
        hits[point.x][point.y] += 1
    for i in range(1000):
        for j in range(1000):
            if hits[i][j] >= 2:
                print(hits[i][j])
                score += 1
    print(f"score is {score}")


def get_line_if_straight(line):
    x1, y1 = line.split(" -> ")[0].split(",")
    x2, y2 = line.split(" -> ")[1].split(",")
    if x1 == x2 or y1 == y2:
        return Line(x1, x2, y1, y2)


def get_line(line):
    x1, y1 = line.split(" -> ")[0].split(",")
    x2, y2 = line.split(" -> ")[1].split(",")
    return Line(x1, x2, y1, y2)


def solution2(l):
    lines = []
    points = []
    rows, cols = (1000, 1000)
    hits = [[0] * rows for _ in range(cols)]
    score = 0
    for raw_line in l:
        line = get_line(raw_line)
        if line:
            lines.append(line)
    for line in lines:
        points = points + line.get_all_points_in_line()
    for point in points:
        hits[point.x][point.y] += 1
    for i in range(1000):
        for j in range(1000):
            if hits[i][j] >= 2:
                print(hits[i][j])
                score += 1
    print(f"score is {score}")


if __name__ == "__main__":
    dir = os.path.abspath(os.path.dirname(__file__))
    with open(os.path.join(dir, "Day05.txt")) as file:
        _input = file.read().splitlines()

    print(solution1(_input))
    print(solution2(_input))
