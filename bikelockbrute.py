import enchant
import sys

dial1 = raw_input("Enter characters on first dial:")
dial2 = raw_input("Enter characters on second dial:")
dial3 = raw_input("Enter characters on third dial:")
dial4 = raw_input("Enter characters on fourth dial:")

if len(dial1) != len(dial2):
	sys.exit("dials should have same number of characters")

if len(dial2) != len(dial3):
	sys.exit("dials should have same number of characters")

if len(dial3) != len(dial4):
	sys.exit("dials should have same number of characters")

d = enchant.Dict("en_US")
count = 0
for c1 in dial1:
	for c2 in dial2:
		for c3 in dial3:
			for c4 in dial4:
				tempstr = c1+c2+c3+c4
				if d.check(tempstr) is True:
					count = count + 1
					print tempstr
print "Total combinations:" + str(count)	
