#! /usr/bin/ruby

gcode = nil

ARGF.each do |s|
  t = s.encode("UTF-8", "Shift_JIS").strip
  if gcode.nil? then
    gcode = t
  else
    print "(#{gcode} . #{t})\n"
    gcode = nil
  end
end
