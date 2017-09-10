import time
import datetime
import serial

ser = serial.Serial(
    port='/dev/rfcomm0',
    baudrate=115200,
    parity=serial.PARITY_NONE,
    stopbits=serial.STOPBITS_ONE,
    bytesize=serial.EIGHTBITS,
    timeout=None
)

Medicine = {}

try:
	ser.open()
except Exception, e:
	print "error open serial port"
	exit()

if ser.isOpen():
	ser.flushInput()
	ser.flushOutput()

	while True:
		incomingMssg = ser.readline()

		if(incomingMssg != null) {
			ser.flushInput()
			inString = incomingMssg.split("%")
			
			if(int(inString[0]) == 1)
				for i in range(1, lens(inString)):
					parse = inString[i].split(" ")
					time = datetime.time(hour= parse[1], minute = parse[2], second = 0)
					tup = (parse[0], time)
					

		}


