# 打印日历
import datetime
import calendar
import locale

textcal = calendar.TextCalendar()
textcal.pryear(2019)
loc = locale.getlocale()
locaetexcal = calendar.LocaleTextCalendar(locale=loc)
dt = datetime.date.today()
locaetexcal.prmonth((int(dt.year)), (int(dt.month)), w=2)
