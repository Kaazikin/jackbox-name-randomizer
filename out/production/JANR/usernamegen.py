import random
words = []
usernames = []
f = open("sowpods.txt","r")
for x in f:
    if len(x.strip()) >= 3 and len(x.strip()) <= 9:
        words.append(x.strip())
f.close()
random.seed()

for i in range(100000):
    name = "".join(random.choices(words, k=2))
    if len(name) <= 12:
        usernames.append(name)
        print("Added " + name)


with open('usernames.txt', 'w') as f:
    for item in usernames:
        f.write("%s\n" % item)
