import sys
import os
from java.lang import System
import getopt
# Below args are passed by the ant script
adminUser=sys.argv[1]
adminPassword=sys.argv[2]
adminUrl=sys.argv[3]
earLocation=sys.argv[4]
repositoryName=sys.argv[5]
applicationName=sys.argv[6]
repositoryType=sys.argv[7]
repositoryJndiName=sys.argv[8]
targetServerName=sys.argv[9]
command=sys.argv[10]

# Connect to WLS
print '############### Connecting to domain ###############'
connect(adminUser, adminPassword, adminUrl)
#domainRuntime()
print 'Successfully connected to the domain\n'

# Stop the application
def stopApp():
 print '############### Stopping application ###############'
 stopApplication(applicationName)
 print 'Stop done\n'

# Undeploy the applciation
def undeployApp():
 print '############### Undeploy start ###############'
 edit()
 startEdit(-1,-1,'false')
 undeploy(applicationName, targetServerName)
 save()
 activate()
 print 'Undeploy done\n'

# Deploy the application
def deployApp():
 print '############### Deploy start ###############'
 print 'Configuring metadata repository ..'
 serverConfig()
 # Returns a handle to the MDSArchiveConfig object for the specified archive 
 archive = getMDSArchiveConfig(fromLocation=earLocation)
 # Sets the connection details for the application metadata repository
 archive.setAppMetadataRepository(repository=repositoryName, partition=applicationName,
 type=repositoryType, jndi=repositoryJndiName)
 archive.save()
 print 'Metadata repository configuration is done.'
 edit()
 startEdit(-1,-1,'false')
 deploy(appName=applicationName, path=earLocation, targets=targetServerName, upload='true')
 save()
 activate()
 print 'Deploy done\n'

# Start the application 
def startApp(): 
 print '############### Starting application ###############'
 startApplication(applicationName)
 print 'Start done\n'
# Deploy script init- First Stop the application and then undeploy. 
# After undeploying, deploy the application and restart

#========================
#Server Operations
#========================
#==============================================
#Checking Server Status
#==============================================
def _serverstatus(targetServerName):
    try:
        cd('domainRuntime:/ServerLifeCycleRuntimes/'+targetServerName);
        serverState = cmo.getState()
        if serverState == "RUNNING":
            print 'Server ' + targetServerName + ' is :[' + serverState + ']';
        elif serverState == "STARTING":
            print 'Server ' + targetServerName + ' is :[' + serverState + ']';
        elif serverState == "UNKNOWN":
            print 'Server ' + targetServerName + ' is :[' + serverState + ']';
        else:
            print 'Server ' + targetServerName + ' is :[' + serverState + ']';
        return serverState
    except:
        print 'Not able to get the ' + serverState + 'server status. Please try again\n';
        print 'Please check logged in user has full access to complete the requested operation on ' + targetServerName + '\n';
        exit()

#==============================================
#Start Server Block
#==============================================

def _startServer(targetServerName):
    try:
	print '############### Starting server ' + targetServerName + ' ###############'
        cd('domainRuntime:/ServerLifeCycleRuntimes/'+targetServerName);
        cmo.start();
        state=_serverstatus(targetServerName);
        while (state!='RUNNING'):
            state=_serverstatus(targetServerName);
            java.lang.Thread.sleep(5000);
			
	print 'Server started.\n'
    except:
        print 'Error in getting current status of ' + targetServerName + '\n';
        print 'Please check logged in user has full access to complete the start operation on ' + targetServerName + '\n';
        exit()
#==============================================
#Stop Server Block
#==============================================

def _stopServer(targetServerName):
    try:
	print '############### Stopping server ' + targetServerName + ' ###############'
        cd('domainRuntime:/ServerLifeCycleRuntimes/'+targetServerName);
        cmo.forceShutdown();
        state=_serverstatus(targetServerName);
        while (state!='SHUTDOWN'):
            state=_serverstatus(targetServerName);
            java.lang.Thread.sleep(5000);
    except:
        print 'Error in getting current status of ' + targetServerName + '\n';
        print 'Please check logged in user has full access to complete the stop operation on ' + targetServerName + '\n';
        exit()
#==============================================
#Server Control Operations - Main
#==============================================		
def serverControlMain():
    try:
        if command =='status' :
            _serverstatus(targetServerName);
        elif command =='stop':
            state=_serverstatus(targetServerName);
            if state!='SHUTDOWN' :
                _stopServer(targetServerName);
        elif command =='start':
            state=_serverstatus(targetServerName);
            if state!='RUNNING' :
                print 'Trying To Start Server:' + targetServerName + '...';
                _startServer(targetServerName);
        elif command =='restart':
			print 'Restarting server:' + targetServerName + '...';		
			state=_serverstatus(targetServerName);
			if state!='SHUTDOWN':
				_stopServer(targetServerName);
				state=_serverstatus(targetServerName);
			if state!='RUNNING':
				_startServer(targetServerName);
        elif command == "stopall":
            try:
                cd('/Servers')
                allServers=ls('/Servers', returnMap='true')
                for p_server in allServers:
                    if p_server == 'AdminServer':
                        continue
                    else:
                        _stopServer(p_server);
            except Exception, e:
                print "Error Occured"
        elif command == "startall":
            try:
                cd('/Servers')
                allServers=ls('/Servers', returnMap='true')
                for p_server in allServers:
                    if p_server == 'AdminServer':
                        continue
                    else:
                        _startServer(p_server);
            except Exception, e:
                print "Error Occured"
        elif command == "statusall":
            try:
                cd('/Servers')
                allServers=ls('/Servers', returnMap='true')
                for p_server in allServers:
                    _serverstatus(p_server);
            except Exception, e:
                print "Error Occured"
        else:
           print 'Not able to understand the command supplied.'
    except:
        print 'Error during lifecycle operation of ' +targetServerName+ '\n'
        exit();
try:
 try:
  stopApp()
 except:
  print sys.exc_info()[0]
 try:
  undeployApp()
 except:
  print sys.exc_info()[0]
 serverControlMain()
 deployApp()
 serverControlMain()
 startApp()
 print '############### Disconnecting from server ###############'
 disconnect()
 exit()
except:
 print 'Unexpected error: ', sys.exc_info()[0]
 dumpStack()
 raise