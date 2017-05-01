import requests
import json
from getpass import getpass
from requests.auth import HTTPBasicAuth

headers = {'Host':'192.168.0.1','Connection':'keep-alive', 'Cache-Control':'max-age=0', 'Upgrade-Insecure-Requests':'1', 'Referer':'http://192.168.0.1/RouterStatus.htm', 'User-Agent':'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36', 'Accept':'gzip, deflate, sdch', 'Accept-Language':'en-US,en;q=0.8'}

password=getpass(prompt='Enter admin password:')
r= requests.get('http://192.168.0.1/Reboot.htm', auth=HTTPBasicAuth('admin',password), headers=headers)
print r.text
print r.history
